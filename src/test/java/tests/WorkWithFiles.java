package tests;


import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tests.model.Student;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import static org.junit.jupiter.api.Assertions.*;

public class WorkWithFiles {

    private ClassLoader cl = WorkWithFiles.class.getClassLoader();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void zipParsingFilesTest() throws Exception {
        try (ZipInputStream zis = new ZipInputStream(
                cl.getResourceAsStream("archive.zip")
        )) {
            ZipEntry entry;

            while ((entry = zis.getNextEntry()) != null) {
                System.out.println(entry.getName());
            }
        }
    }

    @Test
    void readerPdfFilesTest() throws Exception {
        try (ZipInputStream zis = new ZipInputStream(
                cl.getResourceAsStream("archive.zip")
        )) {
            ZipEntry entry;

            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().endsWith(".pdf")) {
                    PDF pdf = new PDF(zis);
                    assertTrue(pdf.text.contains("Это документ в формате PDF, " +
                            "который был создан для тестирования загрузки файлов."));
                    System.out.println(pdf.text);
                }
            }
        }
    }

    @Test
    void readerXslFilesTest() throws Exception {
        try (ZipInputStream zis = new ZipInputStream(
                cl.getResourceAsStream("archive.zip")
        )) {
            ZipEntry entry;

            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().endsWith(".xls")) {
                    XLS xls = new XLS(zis);
                    assertEquals("Jane", xls.excel.getSheetAt(0).getRow(4).getCell(3)
                            .getStringCellValue());
                    assertEquals("2013", xls.excel.getSheetAt(0).getRow(4).getCell(4)
                            .getStringCellValue());
                    assertEquals("81878,9972414417", xls.excel.getSheetAt(0).getRow(4).getCell(5)
                            .getStringCellValue());
                }
            }
        }
    }

    @Test
    void readerCsvfilwsTest() throws Exception {
        try (ZipInputStream zis = new ZipInputStream(
                cl.getResourceAsStream("archive.zip")
        )) {
            ZipEntry entry;

            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().endsWith(".csv")) {
                    CSVReader csvReader = new CSVReader(new InputStreamReader(zis));

                    List<String[]> example_1kb = csvReader.readAll();
                    Assertions.assertEquals("name,phoneNumber,email,address,userAgent,hexcolor",
                            "name,phoneNumber,email,address,userAgent,hexcolor");

                    for (String[] line : example_1kb) {
                        System.out.println(String.join(", ", line));
                    }
                }
            }
        }
    }

    @Test
    void jsonParsingTest() throws Exception {
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("Student.json")) {
            assertNotNull(is, "Student.json отсутствует");

            Student actual = objectMapper.readValue(is, Student.class);

            Assertions.assertEquals("Кирилл", actual.getName());
            Assertions.assertEquals("Санкт-Петербург", actual.getAddress().getCity());

            System.out.println("Увлечения студента " + actual.getName() + ": " + String.join(", ", actual.getHobbies()));
        }
    }
}
