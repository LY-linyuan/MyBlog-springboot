package com.tang.blog.service.impl;

import com.tang.blog.dao.mapper.TagMapper;
import com.tang.blog.dao.pojo.Tag;
import com.tang.blog.service.TagService;
import com.tang.blog.vo.TagVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author 临渊
 * @Date 2022-09-17 15:18
 */

@Service
public class TagServiceImpl implements TagService {

    @Resource
    TagMapper tagMapper;

    @Override
    public List<TagVo> findTagsByArticleId(Long articleId) {
        // Mybatis无发进行多表查询
        List<Tag> tagList = tagMapper.findTagsByArticleId(articleId);
        return copyList(tagList);
    }

    private List<TagVo> copyList(List<Tag> tagList) {
        List<TagVo> tagVoList = new ArrayList<TagVo>();
        for (Tag tag: tagList) {
            tagVoList.add(copy(tag));
        }
        return tagVoList;
    }

    private TagVo copy(Tag tag) {
        TagVo tagVo = new TagVo();
        BeanUtils.copyProperties(tag, tagVo);
        return tagVo;
    }

    @Override
    public List<Tag> hots(int limit) {
        List<Long> tagIds = tagMapper.findHotsTagIds(limit);

        if (CollectionUtils.isEmpty(tagIds)) {
            return Collections.emptyList();
        }
        List<Tag> tagList = tagMapper.findTagsByTagIds(tagIds);
        return tagList;
    }
}
