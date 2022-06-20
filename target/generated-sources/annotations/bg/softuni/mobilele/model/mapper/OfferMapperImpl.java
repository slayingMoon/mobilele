package bg.softuni.mobilele.model.mapper;

import bg.softuni.mobilele.model.dto.AddOfferDto;
import bg.softuni.mobilele.model.entity.Offer;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-20T17:33:04+0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.3 (Amazon.com Inc.)"
)
@Component
public class OfferMapperImpl implements OfferMapper {

    @Override
    public Offer addOfferDtoToOfferEntity(AddOfferDto addOfferDto) {
        if ( addOfferDto == null ) {
            return null;
        }

        Offer offer = new Offer();

        offer.setEngine( addOfferDto.getEngine() );
        offer.setImageUrl( addOfferDto.getImageUrl() );
        offer.setTransmission( addOfferDto.getTransmission() );

        return offer;
    }
}
