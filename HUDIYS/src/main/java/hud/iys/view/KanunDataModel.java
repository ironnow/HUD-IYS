package hud.iys.view;

import java.util.List;
import javax.faces.model.ListDataModel;
import hud.iys.model.Kanun;
import org.primefaces.model.SelectableDataModel;
 
public class KanunDataModel extends ListDataModel<Kanun> implements SelectableDataModel<Kanun> {  
 
    public KanunDataModel() {
    }
 
    public KanunDataModel(List<Kanun> data) {
        super(data);
    }
     
    @Override
    public Kanun getRowData(String rowKey) {
         
        List<Kanun> kanunlar = (List<Kanun>) getWrappedData();
         
        for(Kanun kanun : kanunlar) {
            if((Integer.toString(kanun.getKanunId())).equals(rowKey))
                return kanun;
        }
         
        return null;
    }
 
    @Override
    public Object getRowKey(Kanun kanun) {
        return kanun.getKanunId();
    }
}