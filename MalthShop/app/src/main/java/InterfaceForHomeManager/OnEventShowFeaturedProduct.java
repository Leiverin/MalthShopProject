package InterfaceForHomeManager;

import ModelHome.Component;
import ModelHome.FeaturedProduct;

public interface OnEventShowFeaturedProduct {
    void onClickShowFeaturedProduct(FeaturedProduct featuredProduct);
    void onClickShowFeaturedComponent(Component component);
}
