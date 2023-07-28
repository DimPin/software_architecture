package HomeWork1.InMemoryModel;

import HomeWork1.ModelElements.Camera;
import HomeWork1.ModelElements.PoligonalModel;
import HomeWork1.ModelElements.Scene;

public class ModelStore implements IModelChanger {
    public PoligonalModel Models;
    public Scene Scenes;
    public Camera Cameras;
    private IModelChengedObserver changeObservers;

    public IModelChengedObserver getChangeObservers() {
        return changeObservers;
    }

    public Scene GetScena(int num) {
        return Scenes;
    }

    @Override
    public void NotifyChange(IModelChanger sender) {
        
    }
}
