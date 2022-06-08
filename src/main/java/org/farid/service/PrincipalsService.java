package org.farid.service;

import org.farid.configuration.resources.ApplicationProperties;
import org.farid.model.dto.BaseDTO;
import org.farid.model.dto.MetaDTO;
import org.farid.model.dto.TitleDTO;
import org.farid.model.intrface.IPrincipals;
import org.farid.repository.PrincipalsRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PrincipalsService implements IPrincipals {

    final ApplicationProperties applicationProperties;
    final PrincipalsRepository principalsRepository;

    protected PrincipalsService(ApplicationProperties applicationProperties,
                                PrincipalsRepository principalsRepository

    ) {
        this.applicationProperties = applicationProperties;
        this.principalsRepository = principalsRepository;
    }

    @Override
    public BaseDTO getTitleDirectorWriterAreSame() {
        List<Object[]> objects = principalsRepository.getTitleDirectorWriterAreSame();
        List<TitleDTO> reviewResponses = new ArrayList<>();
        for (Object[] title : objects) {
            reviewResponses.add(TitleDTO.builder()
                    .titleType((title[0] != null) ? (String) title[0] : "")
                    .primaryTitle((title[1] != null) ? (String) title[1] : "")
                    .build()
            );
        }
        return BaseDTO.builder()
                .meta(MetaDTO.getInstance(applicationProperties))
                .data(reviewResponses)
                .build();
    }
}
