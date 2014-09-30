package hud.iys.view;

import java.util.List;
import javax.faces.model.ListDataModel;
import hud.iys.model.Teblig;
import org.primefaces.model.SelectableDataModel;
 
public class TebligDataModel extends ListDataModel<Teblig> implements SelectableDataModel<Teblig> {  
 
    public TebligDataModel() {
    }
 
    public TebligDataModel(List<Teblig> data) {
        super(data);
    }
     
    @Override
    public Teblig getRowData(String rowKey) {
         
        List<Teblig> tebliglar = (List<Teblig>) getWrappedData();
         
        for(Teblig teblig : tebliglar) {
            if((Long.toString(teblig.getTebligId())).equals(rowKey))
                return teblig;
        }
         
        return null;
    }
 
    @Override
    public Object getRowKey(Teblig teblig) {
        return teblig.getTebligId();
    }
}