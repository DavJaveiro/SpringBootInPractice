package br.com.intelliocr.intelliocr.ocr.repository;

import br.com.intelliocr.intelliocr.ocr.entity.OcrResult;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OcrResultRepository extends JpaRepository<OcrResult, Id> {

}
