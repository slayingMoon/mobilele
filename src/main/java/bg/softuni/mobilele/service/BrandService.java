package bg.softuni.mobilele.service;

import bg.softuni.mobilele.model.dto.BrandDto;
import bg.softuni.mobilele.model.dto.ModelDto;
import bg.softuni.mobilele.model.entity.Brand;
import bg.softuni.mobilele.model.entity.Model;
import bg.softuni.mobilele.repository.BrandRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandService {

    private final BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public List<BrandDto> getAllBrands() {
        return brandRepository
                .findAll()
                .stream()
                .map(this::mapBrand)
                .collect(Collectors.toList());
    }

    private BrandDto mapBrand(Brand brand) {
        List<ModelDto> models = brand
                .getModels()
                .stream()
                .map(this::mapModel)
                .collect(Collectors.toList());

        return new BrandDto()
                .setModels(models)
                .setName(brand.getName());
    }

    private ModelDto mapModel(Model model) {
        return new ModelDto()
                .setId(model.getId())
                .setName(model.getName());
    }

}
