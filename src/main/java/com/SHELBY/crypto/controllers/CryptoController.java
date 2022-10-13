package com.SHELBY.crypto.controllers;

import com.SHELBY.crypto.domain.Prices;
import com.SHELBY.crypto.repo.PricesRepository;
import com.SHELBY.crypto.service.CryptosParser;
import com.SHELBY.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CryptoController {

    @Autowired
    private PricesRepository pricesRepository;

    @GetMapping("/cryptocurrency")
    public String getInformation(@RequestParam(required = false, defaultValue = "") String symbol, Model model) {
        try {
            String price = CryptosParser.getCrypto(symbol);
            Prices prices = new Prices(symbol, price);
            pricesRepository.save(prices);
            if (pricesRepository.findById(prices.getId()).isPresent() && symbol != null) {
                model.addAttribute("symbol", pricesRepository.findById(prices.getId()).get().getSymbol());
                model.addAttribute("price", pricesRepository.findById(prices.getId()).get().getPrice() + " USD");
            }
        } catch (Exception e) {
            model.addAttribute("price", "Криптовалюта недоступна к просмотру или проверьте корректность ввода данных");
        }
        return "cryptocurrency";
    }

}
