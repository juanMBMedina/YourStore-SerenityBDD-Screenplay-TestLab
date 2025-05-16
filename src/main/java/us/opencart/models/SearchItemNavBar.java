package us.opencart.models;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SearchItemNavBar {

    public static final String DEFAULT_VALUE = "N/A";

    private String category;
    private String subcategory;
    private String itemName;

}
