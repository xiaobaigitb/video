package com.zhiyou.video.service.impl;

import com.zhiyou.video.mapper.SubjectMapper;
import com.zhiyou.video.model.SubjectModel;
import com.zhiyou.video.service.ISubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SubjectServiceImpl implements ISubjectService {
    @Autowired
    SubjectMapper subjectMapper;
    @Override
    public List<SubjectModel> querySubjects() {
        return subjectMapper.querySubjects();
    }
}
