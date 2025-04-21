package br.com.intelliocr.intelliocr.ocr.service;

import br.com.intelliocr.intelliocr.deepseekApi.service.DeepSeekTranslationService;
import br.com.intelliocr.intelliocr.ocr.entity.OcrResult;
import br.com.intelliocr.intelliocr.ocr.repository.OcrResultRepository;
import net.sourceforge.tess4j.Tesseract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.net.URISyntaxException;
import java.time.LocalDateTime;

@Service
public class OcrService {

    @Autowired
    private final DeepSeekTranslationService deepSeekTranslationService;

    private final OcrResultRepository ocrResultRepository;

    public OcrService(OcrResultRepository ocrResultRepository,
                      DeepSeekTranslationService deepSeekTranslationService) {
        this.ocrResultRepository = ocrResultRepository;
        this.deepSeekTranslationService = deepSeekTranslationService;
    }

    public String extractTextAndSave(MultipartFile file) throws Exception {
        // Salvar o arquivo temporariamente
        File convFile = new File(System.getProperty("java.io.tmpdir") + "/" + file.getOriginalFilename());
        file.transferTo(convFile);

        Tesseract tesseract = new Tesseract();

        try {
            // Acessar o diretório tessdata dentro de resources
            File tessDataFolder = new File(getClass().getClassLoader().getResource("tessdata").toURI());
            tesseract.setDatapath(tessDataFolder.getAbsolutePath());
        } catch (URISyntaxException | NullPointerException e) {
            throw new RuntimeException("Erro ao localizar o diretório tessdata", e);
        }

        tesseract.setLanguage("eng");

        // Realizar OCR
        String extractedText = tesseract.doOCR(convFile)
                .replaceAll("\\s+", " ") // Substitui todos os espaços em branco (tabs, quebras, etc) por um único espaço
                .trim();

        // translate with DeepSeek
        String translatedText = deepSeekTranslationService.traduzirTexto(extractedText);

        // Salvar resultado no banco
        OcrResult result = new OcrResult();
        result.setFileName(file.getOriginalFilename());
        result.setExtractedText(translatedText);
        result.setProcessedAt(LocalDateTime.now());

        ocrResultRepository.save(result);

        return translatedText;
    }
}
