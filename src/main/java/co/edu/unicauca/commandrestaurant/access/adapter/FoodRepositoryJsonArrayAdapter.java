
package co.edu.unicauca.commandrestaurant.access.adapter;

import co.edu.unicauca.commandrestaurant.access.IFoodRepository;
import co.edu.unicauca.commandrestaurant.domain.Food;
import co.edu.unicauca.commandrestaurant.domain.FoodTypeEnum;
import java.util.List;

/**
 *
 * @author Rivera
 */

/**
 * Clase adaptador que conecta una el repositorio JjsonArray Repository
 * con la interfaz IFoodRepository
 */
public class FoodRepositoryJsonArrayAdapter implements IFoodRepository{
    
    private FoodJsonArrayRepository jSonFood;

    public FoodRepositoryJsonArrayAdapter() {
        jSonFood = new FoodJsonArrayRepository();
    }
    
    
    @Override
    public Food findById(int id) {     
        String [] jsonFood = null;
        String foodFind = jSonFood.getById(String.valueOf(id));
        if( foodFind != null){
            jsonFood = foodFind.split("'");
            return new Food(Integer.parseInt(jsonFood[0]),jsonFood[1],FoodTypeEnum.valueOf(jsonFood[2]));
        }
        return null;
        
    }

    @Override
    public List<Food> findAll() {
        return jSonFood.getdAll();
    }

    @Override
    public boolean create(Food customer) {
        String food = customer.getId() + "'" + customer.getName() + "'" + String.valueOf(customer.getType());
        return jSonFood.add(food);
    }

    @Override
    public boolean update(Food customer) {
        return jSonFood.modify(customer);
    }

    @Override
    public void delete(int id) {
        jSonFood.remove(String.valueOf(id));
    }
    
}
