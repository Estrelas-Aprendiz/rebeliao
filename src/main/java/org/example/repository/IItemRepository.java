package org.example.repository;

import org.example.model.ItemModel;

import java.util.List;

public interface IItemRepository {

    public abstract void adicionaItem(ItemModel itemModel);
    public abstract List<ItemModel> buscaTodosItens();
    public abstract ItemModel buscaItemPorId(Long id);

}
