# 说明
- 项目启动以后定向到静态页面index.html
  - 输入http://localhost:8080/product_input.action转到表单页面。如图image中的图1，图2，图3
- 该SpringMVC项目是基于SpringMVCStudy3项目改进的，唯一不同是加上了SpringMVC的依赖与注入技术@Service和@Autowired
  -      <!-- 添加扫描服务的包 -->
            <context:component-scan base-package="app.service"/>
            添加服务层
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
  - 同时使用了redirect(重定向)，(forward)转发比重定向快，因为重定向需要经过客户端，转发不需要经过客户端。但是重定向可以重新定向到一个外部的网站，而转发是不可以的。
  - ![](https://github.com/zkydrx/SpringMVCStudy4/blob/master/src/main/webapp/image/4.png?raw=true)
    -       @RequestMapping(value="/product_save",method = RequestMethod.POST)
                public String saveProduct(ProductForm productForm, RedirectAttributes redirectAttributes)
                {
                    logger.info("saveProduct called");
                    // no need to create and instantiate a ProductForm
                    // create Product
                    Product product = new Product();
                    product.setName(productForm.getName());
                    product.setDescription(productForm.getDescription());
                    try
                    {
                        product.setPrice(Float.parseFloat(productForm.getPrice()));
                    }
                    catch (NumberFormatException e)
                    {
                        e.printStackTrace();
                    }
            
                    // add product
                    Product saveProduct = productService.add(product);
            
                    redirectAttributes.addFlashAttribute("message","The product was successful added.");
                    return "redirect:/product_view/"+saveProduct.getId();
                }
            
                @RequestMapping(value="/product_view/{id}")
                public String viewProduct(@PathVariable long id, Model model)
                {
                    Product product = productService.get(id);
                    model.addAttribute("product",product);
                    return "ProductView";
                }