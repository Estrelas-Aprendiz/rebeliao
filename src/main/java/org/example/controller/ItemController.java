package org.example.controller;

import org.example.model.ItemModel;
import org.example.repository.IItemRepository;
import org.example.service.ItemService;

import java.util.List;

public class ItemController implements IItemRepository {

    private ItemService itemService;

    public ItemController(ItemService itemService){
        this.itemService = itemService;
    }

    @Override
    public void adicionaItem(ItemModel itemModel) {
        itemService.adicionaItem(itemModel);
    }

    @Override
    public List<ItemModel> buscaTodosItens() {
        return itemService.buscaTodosItens();
    }

    @Override
    public ItemModel buscaItemPorId(Long id) {
        return itemService.buscaItemPorId(id);
    }
}
