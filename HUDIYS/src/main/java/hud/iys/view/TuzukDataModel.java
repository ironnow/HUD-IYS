package hud.iys.view;

import java.util.List;
import javax.faces.model.ListDataModel;
import hud.iys.model.Tuzuk;
import org.primefaces.model.SelectableDataModel;
 
public class TuzukDataModel extends ListDataModel<Tuzuk> implements SelectableDataModel<Tuzuk> {  
 
    public TuzukDataModel() {
    }
 
    public TuzukDataModel(List<Tuzuk> data) {
        super(data);
    }
     
    @Override
    public Tuzuk getRowData(String rowKey) {
         
        List<Tuzuk> tuzukler = (List<Tuzuk>) getWrappedData();
         
        for(Tuzuk tuzuk : tuzukler) {
            if((Long.toString(tuzuk.getTuzukId())).equals(rowKey))
                return tuzuk;
        }
         
        return null;
    }
 
    @Override
    public Object getRowKey(Tuzuk tuzuk) {
        return tuzuk.getTuzukId();
    }
}