package bundles;

import java.util.ListResourceBundle;

public class TesteBundleJava extends ListResourceBundle{

	@Override
	protected Object[][] getContents() {
		Object[][] bundle = {{"paulo","luciana"},
							 {"isaac","Jade"}};
		
		return bundle;
	}

}
