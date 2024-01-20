
package com.ayigroup.zieglerfrancisco.interfaces;

import java.util.List;

public interface DaoInterface<T> {
    
    public List<T> getAll();
    
    public T getOne(int id);
    
    public T create(T newEntity);
    
    public T update(T upEntity);
    
    public T delete(T delEntity);
    
}
