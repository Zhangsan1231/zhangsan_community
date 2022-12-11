package com.zhang.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhang.model.dto.CommentDTO;
import com.zhang.model.entity.BmsComment;
import com.zhang.model.entity.UmsUser;
import com.zhang.model.vo.CommentVO;

import java.util.List;


public interface IBmsCommentService extends IService<BmsComment> {
    /**
     *
     *
     * @param topicid
     * @return {@link BmsComment}
     */
    List<CommentVO> getCommentsByTopicID(String topicid);

    BmsComment create(CommentDTO dto, UmsUser principal);
}
