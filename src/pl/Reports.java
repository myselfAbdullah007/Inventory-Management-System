package pl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import DTO.Product;
import dal.ProductDAO;

public class Reports {

    public void createPdfWithTable(String filePath) throws IOException {
        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);

            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
                ProductDAO prod = new ProductDAO();
                List<Product> prodlist = prod.getAllProducts();
            	float margin = 50;
                float yStart = page.getMediaBox().getHeight() - margin;
                float tableWidth = page.getMediaBox().getWidth() - 2 * margin;
                float yPosition = yStart;

                drawTableHeader(contentStream, margin, yStart, tableWidth);
                yPosition -= 15;

                for (Product p:prodlist) {
                    drawTableRow(contentStream, margin, yPosition, tableWidth, p.getProductId(), p.getName(),p.getQunatity());
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
        contentStream.showText("ProductID");
        contentStream.newLineAtOffset(tableWidth * 0.4f, 0);
        contentStream.showText("Name");
        contentStream.newLineAtOffset(tableWidth * 0.4f, 0);
        contentStream.showText("Qunatity");
        contentStream.endText();
    }

    private static void drawTableRow(PDPageContentStream contentStream, float margin, float yPosition, float tableWidth, String product, String name,String quantity) throws IOException {
        contentStream.setFont(PDType1Font.HELVETICA, 12);
        contentStream.beginText();
        contentStream.newLineAtOffset(margin, yPosition);
        contentStream.showText(product);
        contentStream.newLineAtOffset(tableWidth * 0.4f, 0);
        contentStream.showText(name);
        contentStream.newLineAtOffset(tableWidth * 0.4f, 0);
        contentStream.showText(quantity);
        contentStream.endText();
    }
    
}
