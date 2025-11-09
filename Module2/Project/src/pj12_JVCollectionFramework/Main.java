package pj12_JVCollectionFramework;

import pj12_JVCollectionFramework.controller.ProductManagerController;
import pj12_JVCollectionFramework.entity.Product;
import pj12_JVCollectionFramework.repository.ProductManagerRepository;
import pj12_JVCollectionFramework.service.ProductManagerService;
import pj12_JVCollectionFramework.view.ProductView;

public class Main {
    public static void main(String[] args) {
        ProductManagerRepository repository = new ProductManagerRepository();
        ProductManagerService service = new ProductManagerService(repository);
        ProductManagerController controller = new ProductManagerController(service);
        ProductView view = new ProductView(controller);

        view.menu();
    }
}
