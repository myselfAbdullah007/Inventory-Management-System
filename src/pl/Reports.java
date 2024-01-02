package pl;

import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class Reports {

    public static void main(String[] args) {
        try {
            createPdfWithTable("example.pdf");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createPdfWithTable(String filePath) throws IOException {
        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);

            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
                float margin = 50;
                float yStart = page.getMediaBox().getHeight() - margin;
                float tableWidth = page.getMediaBox().getWidth() - 2 * margin;
                float yPosition = yStart;
                float bottomMargin = 70;

                drawTableHeader(contentStream, margin, yStart, tableWidth);
                yPosition -= 15;

                for (int i = 0; i < 10; i++) {
                    drawTableRow(contentStream, margin, yPosition, tableWidth, "Product " + (i + 1), String.valueOf(i + 1));
                    yPosition -= 15;
                }
            }

            document.save(filePath);
        }
    }

    private static void drawTableHeader(PDPageContentStream contentStream, float margin, float yStart, float tableWidth) throws IOException {
        contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
        contentStream.beginText();
        contentStream.newLineAtOffset(margin, yStart);
        contentStream.showText("Product");
        contentStream.newLineAtOffset(tableWidth * 0.4f, 0);
        contentStream.showText("Quantity");
        contentStream.endText();
    }

    private static void drawTableRow(PDPageContentStream contentStream, float margin, float yPosition, float tableWidth, String product, String quantity) throws IOException {
        contentStream.setFont(PDType1Font.HELVETICA, 12);
        contentStream.beginText();
        contentStream.newLineAtOffset(margin, yPosition);
        contentStream.showText(product);
        contentStream.newLineAtOffset(tableWidth * 0.4f, 0);
        contentStream.showText(quantity);
        contentStream.endText();
    }
}
