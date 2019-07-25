package com.example.ci

import static org.junit.Assert.assertTrue


import org.junit.*

import com.lesfurets.jenkins.unit.cps.BasePipelineTestCPS

class ExampleTest extends BasePipelineTestCPS {

    @Before
    void setup() {
        super.setUp()
        helper.registerAllowedMethod("sh", [Map.class], { c ->
            println("Mock - Executing SH command with params: '${c}'")
            return 0
        })

        helper.registerAllowedMethod("sh", [String.class], { c ->
            println("Mock - Executing SH command: '${c}'")
        })
    }

    @Test
    void should_return_true() {
        loadScript('Jenkinsfile')
        printCallStack()
        assertTrue(true)
    }
}