package com.education.course.service.xml;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.education.course.bean.Course;
import com.education.course.bean.to.CourseTO;
import com.education.course.mapper.CourseMapper;
import com.education.course.service.ICourseService;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 课程信息 服务实现类
 * </p>
 *
 * @author Tutu
 * @since 2020-06-18
 */
@Service
@Slf4j
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements ICourseService {

//    存储course课程的索引
    private final static String ES_COURSE_INDEX = "course_index";

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    /**
     *  根据条件分页查询课程信息
     * @param queryCourse
     * @return
     */
    @Override
    public List<Course> getCoursePage(CourseTO queryCourse) {

        Page page = new Page(queryCourse.getCurrend(), queryCourse.getLimit());

        QueryWrapper wrapper = new QueryWrapper();

        if (queryCourse.getCourseName() != null) {
            wrapper.like("course_name", queryCourse.getCourseName());
        }

        if (queryCourse.getStatusId() != -1) {
            wrapper.eq("status_id", queryCourse.getStatusId());
        }

        if (queryCourse.getIsFree() != -1) {
            wrapper.eq("is_free", queryCourse.getIsFree());
        }

        if (queryCourse.getIsPutaway() != -1) {
            wrapper.eq("is_putaway", queryCourse.getIsPutaway());
        }

        IPage iPage = baseMapper.selectPage(page, wrapper);
        return iPage.getRecords();
    }

    /**
     *  更新课程信息
     * @param course
     * @return
     */
    @Override
    public Integer updateCourse(Course course) {
        return baseMapper.updateById(course);
    }

    /**
     *  利用ElasticSearch进行查询
     * @param courseTO
     * @return
     */
    @Override
    public List getElasticSearchInfo(CourseTO courseTO) {

        SearchRequest searchRequest = new SearchRequest(ES_COURSE_INDEX);

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder(); //构建搜索条件
        //根据名称
        MatchQueryBuilder matchQueryBuilder = null;

        if (courseTO.getCourseName() != null) {
            matchQueryBuilder = QueryBuilders.matchQuery("course_name",courseTO.getCourseName());
        }

        searchSourceBuilder.query(matchQueryBuilder);

        searchRequest.source(searchSourceBuilder);
        SearchResponse search = null;
        try {
            search = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info("-----------------------elasticSearch查询出来的数据：" + JSON.toJSONString(search.getHits()));
        return Arrays.asList(search.getHits().getHits());
    }

}
