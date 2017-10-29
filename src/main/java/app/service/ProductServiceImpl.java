package app.service;

import app.domain.Product;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2017-10-29
 * Time: 11:22
 * Description:
 */
@Service
public class ProductServiceImpl implements ProductService
{

    private Map<Long,Product> products=new HashMap<Long,Product>();

    private AtomicLong generator= new AtomicLong();

    public ProductServiceImpl()
    {
        Product product =new Product();
        product.setName("Alibaba");
        product.setDescription("Wondeful");
        product.setPrice(123.33F);
        add(product);
    }

    public Product add(Product product)
    {
        long newId= generator.incrementAndGet();
        product.setId(newId);
        products.put(newId,product);
        return product;
    }

    public Product get(long id)
    {
        return products.get(id);
    }
}
