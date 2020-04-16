package co.com.poli.appmusicmcnm.service;

import co.com.poli.appmusicmcnm.model.ListaModel;

public interface IListaService {

    String addList(ListaModel listaModel);

    String findAll();

    String findOne(Long listId);

    String actList(ListaModel listaModel);

    String delList(Long listId);

}
