package app.service;

import app.domain.Product;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2017-10-29
 * Time: 11:21
 * Description:
 */
public interface ProductService
{
    Product add(Product product);
    Product get(long id);
}
