package org.example.controllers.builders;

import org.example.controllers.managers.BusinessObjectManager;
import org.example.models.clothing.Clothing;
import org.example.models.generic.Order;
import org.example.models.generic.Receipt;

public class ReceiptBuilder
{
    private Receipt receipt = new Receipt();
    private StringBuilder builder = new StringBuilder();

    public Receipt build()
    {
        receipt.setText(builder.toString());
        return receipt;
    }

    public ReceiptBuilder addOrderDetails(Order order)
    {
        double total = 0;

        addHeader();
        builder.append("Order details for "+BusinessObjectManager.getInstance().getCurrentCustomer().getName()+":\n");
        for(Clothing article: order.getArticles())
        {
            builder.append("- ").append(article.getClass().getSimpleName())
                    .append(" | Size: ").append(article.getSize())
                    .append(" | Color: ").append(article.getColor())
                    .append(" | Material: ").append(article.getMaterial())
                    .append(" | Price: ").append(article.getPrice()).append("kr")
                    .append("\n");

            total += article.getPrice();
        }
        builder.append("Total Price: ").append(total).append("kr");
        builder.append("\n");
        addFooter();
        return this;
    }

    private void addHeader()
    {
        builder.append("==== Wigell's E-shop ====\n");
    }

    private void addFooter()
    {
        builder.append("=========================\n");
    }
}
