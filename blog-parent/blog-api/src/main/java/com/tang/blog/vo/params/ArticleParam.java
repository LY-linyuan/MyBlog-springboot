package com.tang.blog.vo.params;

import com.tang.blog.vo.CategoryVo;
import com.tang.blog.vo.TagVo;
import lombok.Data;

import java.util.List;

/**
 * @Author 临渊
 * @Date 2022-09-21 9:59
 */

@Data
public class ArticleParam {

    private Long id;

    private ArticleBodyParam body;

    private CategoryVo category;

    private String summary;

    private List<TagVo> tags;

    private String title;

}
