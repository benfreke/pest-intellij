package com.pestphp.pest

import com.intellij.testFramework.TestDataPath

@TestDataPath("\$CONTENT_ROOT/resources/com/pestphp/pest/PestTestRunLineMarkerProviderTest")
class PestTestRunLineMarkerProviderTest : PestLightCodeFixture() {
    override fun getTestDataPath(): String {
        return "src/test/resources/com/pestphp/pest/PestTestRunLineMarkerProviderTest"
    }

    fun testMethodCallNamedItAndVariableTestIsNotPestTest() {
        val file = myFixture.configureByFile("MethodCallNamedItAndVariableTest.php")

        val testElement = file.firstChild.lastChild.firstChild.firstChild

        assertNull(PestTestRunLineMarkerProvider().getInfo(testElement))
    }

    fun testFunctionCallNamedItWithDescriptionAndClosure() {
        val file = myFixture.configureByFile("PestItFunctionCallWithDescriptionAndClosure.php")

        val testElement = file.firstChild.lastChild.firstChild.firstChild

        assertNotNull(PestTestRunLineMarkerProvider().getInfo(testElement))
    }

    fun testPestTestRunAllButtonOnPhpTag() {
        val file = myFixture.configureByFile("PestItFunctionCallWithDescriptionAndClosure.php")

        val testElement = file.firstChild.firstChild

        assertNotNull(PestTestRunLineMarkerProvider().getInfo(testElement))
    }
}
