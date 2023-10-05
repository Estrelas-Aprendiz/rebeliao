package org.example.repository;

public interface IInventarioRepository {

    public abstract void visualizaInventario(Long idRebelde);
    public abstract void adicionarItemNoInventario(Long idRebelde, Long idItem);


}
