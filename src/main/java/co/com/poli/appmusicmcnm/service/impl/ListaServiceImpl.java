package co.com.poli.appmusicmcnm.service.impl;

import co.com.poli.appmusicmcnm.dao.IListaDao;
import co.com.poli.appmusicmcnm.model.ListaModel;
import co.com.poli.appmusicmcnm.service.IListaService;
import co.com.poli.appmusicmcnm.util.ListaResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ListaServiceImpl implements IListaService {

    private IListaDao iListaDao;
    private ListaResponse listaResponse = new ListaResponse();
    private Gson gson = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create();

    @Autowired
    public ListaServiceImpl(IListaDao iListaDao) {
        this.iListaDao = iListaDao;
    }

    @Override
    @Transactional
    public String addList(ListaModel listaModel) {
        if (listaModel.getName() != null || listaModel.getDescription() != null || listaModel.getSongs() != null) {
            iListaDao.save(listaModel);
            String result = gson.toJson(new ListaResponse(201, "Created"));
            return result + gson.toJson(listaModel);
        }
        return gson.toJson(new ListaResponse(400, "Bad Request"));
    }

    @Override
    public String findAll() {
        List<ListaModel> listaModels = new ArrayList<>();

        for (ListaModel model : iListaDao.findAll()) {
            listaModels.add(model);
        }
        if (!listaModels.isEmpty()) {
            return gson.toJson(listaModels);
        }
        return gson.toJson(new ListaResponse("No hay listas"));
    }

    @Override
    public String findOne(Long listId) {
        if (iListaDao.findById(listId).isPresent()) {
            return gson.toJson(iListaDao.findById(listId));
        }
        return gson.toJson(new ListaResponse(404, "Not Found"));
    }

    @Override
    public String actList(ListaModel listaModel) {
        Optional<ListaModel> listaAux = iListaDao.findById(listaModel.getId());
        if (listaAux.isPresent()) {
            if (listaAux.get().getName().equals(listaModel.getName())) {
                iListaDao.save(listaModel);
                return gson.toJson(new ListaResponse(204, "No Content"));
            } else {
                return gson.toJson(new ListaResponse(409, "Conflict"));
            }
        } else {
            return gson.toJson(new ListaResponse(404, "Not Found"));
        }
    }

    @Override
    public String delList(Long listId) {
        if (iListaDao.findById(listId).isPresent()) {
            iListaDao.deleteById(listId);
            return gson.toJson(new ListaResponse(204, "No Content"));
        }
        return gson.toJson(new ListaResponse(404, "Not Found"));
    }
}
