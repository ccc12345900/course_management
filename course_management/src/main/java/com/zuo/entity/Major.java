package com.zuo.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author admin
 * @since 2022-12-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Major implements Serializable {

    private static final long serialVersionUID=1L;

      private Integer id;

    private String majorName;


}
