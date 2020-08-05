package com.education.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.education.system.bean.Website;
import com.education.system.mapper.WebsiteMapper;
import com.education.system.service.IWebsiteService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 站点信息 服务实现类
 * </p>
 *
 * @author Tutu
 * @since 2020-06-18
 */
@Service
public class WebsiteServiceImpl extends ServiceImpl<WebsiteMapper, Website> implements IWebsiteService {

}
