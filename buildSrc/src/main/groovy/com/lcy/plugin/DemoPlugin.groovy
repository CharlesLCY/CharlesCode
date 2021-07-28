package com.lcy.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Desc:
 * @author Charlie叶晨
 * @date   2021/7/27 06:00
 * @email  15708478830@163.com
 **/
class DemoPlugin implements Plugin<Project> {
    @Override
    void apply(Project target) {
        def extension = target.extensions.create('lcy', DemoExtension)
        target.afterEvaluate {
            println("Hello ${extension.name}")
        }
    }
}