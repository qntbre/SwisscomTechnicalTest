package local.qbr.ProductManager;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CatalogController {
    Catalog catalog;

    public CatalogController() {
        catalog = new Catalog();
        catalog.addType("type1");
        catalog.addType("type2");
        catalog.addType("typebeat");

        catalog.addProduct("type1", "Iphone", "phone");
        catalog.addProduct("type2", "rock", "what a rock");
        catalog.addProduct("type3", "The declaration of independence", "Who would ever steal that ?");
    }

    @GetMapping("/products/{id}")
    String oneProduct(@PathVariable Long id) {
       if(catalog.getById(id) !=  null)
            return (catalog.getById(id).toString());
        return (HttpStatus.NOT_FOUND.toString());
    }

    @PutMapping("/new/product")
    String newProduct(@RequestBody Product newProduct) {
        if(catalog.addProduct(newProduct))
            return (HttpStatus.CREATED.toString());
        return (HttpStatus.BAD_REQUEST.toString());
    }

    @DeleteMapping("/remove/{id}")
    String newProduct(@PathVariable Long id) {
        if(catalog.removeProduct(id))
            return (HttpStatus.FOUND.toString());
        return (HttpStatus.NOT_FOUND.toString());
    }

    @PostMapping("/remove/{productId}/stock/{amount}")
    String removeStock(@PathVariable Long productId, @PathVariable Long amount) {
        if(catalog.removeStock(productId, amount))
            return (HttpStatus.FOUND.toString());
        return (HttpStatus.NOT_FOUND.toString());
    }

    @PostMapping("/add/{productId}/stock/{amount}")
    String addStock(@PathVariable Long productId, @PathVariable Long amount) {
        if(catalog.addStock(productId, amount))
            return (HttpStatus.FOUND.toString());
        return (HttpStatus.NOT_FOUND.toString());
    }
}