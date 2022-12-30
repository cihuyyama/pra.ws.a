/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pra.sehat.ws.a;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author iqbal al habib
 */

@Controller
@ResponseBody
public class myController {
    
    Barang data = new Barang();
    BarangJpaController ctrl = new BarangJpaController();
    
    @RequestMapping("/get")
    public List<Barang> getBarang(){
        return ctrl.findBarangEntities();
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@RequestBody Barang barang){
        try {
            ctrl.create(barang);
            return "berhasil";
        } catch (Exception e) {
            return "gagal";
        }
    }
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") int id){
        try {
            ctrl.destroy(id); 
            return "Data Deleted";
        } catch (Exception e) {
            return "Data Not Found";
        }
    }
    
}
