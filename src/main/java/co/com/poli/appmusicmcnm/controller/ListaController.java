package co.com.poli.appmusicmcnm.controller;

import co.com.poli.appmusicmcnm.model.ListaModel;
import co.com.poli.appmusicmcnm.service.IListaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ListaController {

    private IListaService iListaService;

    public ListaController() {
    }

    @Autowired
    public ListaController(IListaService iListaService) {
        this.iListaService = iListaService;
    }

    @GetMapping(value = "/status")
    public String status() {
        return "Running Server";
    }

    @PostMapping(value = "/lists")
    public String addList(@RequestBody ListaModel listaModel) {
        return iListaService.addList(listaModel);
    }

    @GetMapping(value = "/lists")
    public String findAllLists() {
        return iListaService.findAll();
    }

    @GetMapping(value = "/lists/{listName}")
    public String findOneList(@PathVariable Long listName) {
        return iListaService.findOne(listName);
    }

    @PutMapping(value = "/lists")
    public String actList(@RequestBody ListaModel listaModel) {
        return iListaService.actList(listaModel);
    }

    @DeleteMapping(value = "/lists/{listId}")
    public String delList(@PathVariable Long listId) {
        return iListaService.delList(listId);
    }
}
