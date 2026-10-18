
package com.javabs.repository;

import com.javabs.domain.GenConfig;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 李寻欢
 * @date 2023-01-14
 */
public interface GenConfigRepository extends JpaRepository<GenConfig,Long> {

    /**
     * 查询表配置
     * @param tableName 表名
     * @return /
     */
    GenConfig findByTableName(String tableName);
}
