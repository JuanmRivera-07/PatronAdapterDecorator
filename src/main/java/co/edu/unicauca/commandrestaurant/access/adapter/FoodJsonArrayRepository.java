package co.edu.unicauca.commandrestaurant.access.adapter;

import co.edu.unicauca.commandrestaurant.domain.Food;
import co.edu.unicauca.commandrestaurant.domain.FoodTypeEnum;
import co.edu.unicauca.commandrestaurant.domain.decorator.CryptFood;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rivera
 */

/**
 * FoodJsonArrayRepository repositorio que guarda  y recupera comidas
 * en un arreglo String Json
 * 
 */
public class FoodJsonArrayRepository {

//    private static List<Food> components;
    private static List<String> foods;

    public FoodJsonArrayRepository() {
        if (foods == null) {
            foods = new ArrayList<>();
            initData();
        }
    }

    private void initData() {

        Food food1 = new CryptFood(1, "Fríjoles", FoodTypeEnum.PRINCIPIO);
        Food food3 = new CryptFood(2, "Sopa de verduras", FoodTypeEnum.ENTRADA);
        Food food2 = new CryptFood(3, "Jugo de mango", FoodTypeEnum.JUGO);

        foods.add(food1.getId() + "'" + food1.getName() + "'" + String.valueOf(food1.getType()));
        foods.add(food2.getId() + "'" + food2.getName() + "'" + String.valueOf(food2.getType()));
        foods.add(food3.getId() + "'" + food3.getName() + "'" + String.valueOf(food3.getType()));

    }

    public boolean add(String food) {
        foods.add(food);
        return true;
    }

    /**
     * Eliminar comida 
     * @param id comida a leiminar
     */
    public void remove(String id) {
        int i;
        String[] idFood = null;
        for (i = 0; i < foods.size(); i++) {
            idFood = foods.get(i).split("'");
            if (id.equals(idFood[0])) {
                foods.remove(i);
            }
        }

    }
    
    /**
     * MOdificar
     * @param food comidaa elimiminar
     * @return true si exito, false fallo
     */
    public boolean modify(Food food) {

        String[] idFood = null;
        for (int i = 0; i < foods.size(); i++) {
            idFood = foods.get(i).split("'");
            if (String.valueOf(food.getId()).equals(idFood[0])) {
                foods.set(i, food.getId() + "'" + food.getName() + "'" + String.valueOf(food.getType()));
                return true;
            }
        }
        return false;

    }
    
    /**
     * Obtnener una comida
     * @param id de la comida a obtener
     * @return comida en formato json
     */
    public String getById(String id) {
        String[] idFood = null;
 
        for (int i = 0; i < foods.size(); i++) {
            idFood = foods.get(i).split("'");
            if (id.equals(idFood[0])) {
                return foods.get(i);
            }
        }
        return null;
    }
    
    /**
     * obtiene todas las comidas
     * @return lista de comidas
     */
    public List<Food> getdAll() {
        List<Food> components = new ArrayList<>();
        String [] findFood = null;
        for (int i = 0; i < foods.size(); i++) {
            findFood = foods.get(i).split("'");
            components.add(new Food(Integer.parseInt(findFood[0]), findFood[1], FoodTypeEnum.valueOf(findFood[2])));
        }
        return components;
    }

}
