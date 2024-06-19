package og.shop.controllers;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import og.shop.models.Item;
import og.shop.models.Receipt;
import og.shop.services.ItemService;
import og.shop.services.ReceiptService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;

@Controller
@RequiredArgsConstructor
public class IndexController {
    private final ItemService itemService;
    private final ReceiptService receiptService;

    @GetMapping("/")
    public String index(Model model) {
        var items = itemService.GetAll();
        model.addAttribute("items", items);
        model.addAttribute("cart", new ArrayList<Item>());

        return "index";
    }

    @GetMapping("/add/{id}")
    public String addItem(@PathVariable("id") Long id, Model model, HttpSession session) {
        var cart = (ArrayList<Item>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
        }
        var addedItem = itemService.GetById(id);
        cart.add(addedItem);

        var items = itemService.GetAll();
        model.addAttribute("items", items);
        session.setAttribute("cart", cart);

        return "index";
    }

    @GetMapping("/cart")
    public String goToCart(HttpSession session, Model model) {
        var cart = (ArrayList<Item>) session.getAttribute("cart");

        model.addAttribute("toPurchase", cart);
        var total = cart.stream().mapToDouble(x -> x.getPrice()).sum();
        model.addAttribute("total", total);

        return "cart";
    }

    @GetMapping("/receipt")
    public String receipt(HttpSession session, Model model) {
        var cart = (ArrayList<Item>) session.getAttribute("cart");
        var total = cart.stream().mapToDouble(x -> x.getPrice()).sum();

        var receipt = new Receipt();
        receipt.setItems(cart);
        receipt.setTotal(total);

        receiptService.Add(receipt);
        model.addAttribute("receipt", receipt);
        session.removeAttribute("cart");
        return "successful";
    }
}
