package org.farid.model.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TitleDTO {

    String titleType;
    String primaryTitle;
}
