
package com.ayigroup.zieglerfrancisco.interfaces;

import java.util.List;

public interface RepositoryInterface<T,R> {
    
    public List<R> getAll();
    
    public R getOne(int id);
    
    public R create(T newEntity);
    
    public R update(T upEntity);
    
    public R delete(T delEntity);

}