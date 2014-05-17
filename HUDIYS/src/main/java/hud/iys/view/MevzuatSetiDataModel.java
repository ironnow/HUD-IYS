package hud.iys.view;

import java.util.List;
import javax.faces.model.ListDataModel;
import hud.iys.model.MevzuatSeti;
import org.primefaces.model.SelectableDataModel;
 
public class MevzuatSetiDataModel extends ListDataModel<MevzuatSeti> implements SelectableDataModel<MevzuatSeti> {  
 
    public MevzuatSetiDataModel() {
    }
 
    public MevzuatSetiDataModel(List<MevzuatSeti> data) {
        super(data);
    }
     
    @Override
    public MevzuatSeti getRowData(String rowKey) {
         
        List<MevzuatSeti> mevzuatSetleri = (List<MevzuatSeti>) getWrappedData();
         
        for(MevzuatSeti mevzuatSeti : mevzuatSetleri) {
            if((Integer.toString(mevzuatSeti.getMevzuatSetiId())).equals(rowKey))
                return mevzuatSeti;
        }
         
        return null;
    }
 
    @Override
    public Object getRowKey(MevzuatSeti mevzuatSeti) {
        return mevzuatSeti.getMevzuatSetiId();
    }
}