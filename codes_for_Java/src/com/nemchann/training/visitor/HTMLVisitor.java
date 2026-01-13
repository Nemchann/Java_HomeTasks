package com.nemchann.training.visitor;

import java.util.List;

public class HTMLVisitor implements Visitor{
    private StringBuilder html = new StringBuilder();

    public String getHTML() {
        return html.toString();
    }
    @Override
    public void visitParagraph(Paragraph paragraph) {
        html.append("<p>")
                .append(paragraph.getText())
                .append("</p>\n");
    }

    @Override
    public void visitImage(Image image) {
        html.append("<img src=\"")
                .append(image.getSrc())
                .append("\" alt=\"")
                .append(image.getAlt())
                .append("\">\n");
    }

    @Override
    public void visitTable(Table table) {
        html.append("<table>\n");
        for (List<String> row : table.getData()) {
            html.append("  <tr>\n");
            for (String cell : row) {
                html.append("    <td>")
                        .append(cell)
                        .append("</td>\n");
            }
            html.append("  </tr>\n");
        }
        html.append("</table>\n");
    }

}
