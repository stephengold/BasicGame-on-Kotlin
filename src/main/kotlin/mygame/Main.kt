/*
Copyright (c) 2024 Stephen Gold

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met:

1. Redistributions of source code must retain the above copyright notice, this
   list of conditions and the following disclaimer.

2. Redistributions in binary form must reproduce the above copyright notice,
   this list of conditions and the following disclaimer in the documentation
   and/or other materials provided with the distribution.

3. Neither the name of the copyright holder nor the names of its
   contributors may be used to endorse or promote products derived from
   this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
package mygame

import com.jme3.app.SimpleApplication
import com.jme3.material.Material
import com.jme3.material.Materials
import com.jme3.math.ColorRGBA
import com.jme3.renderer.RenderManager
import com.jme3.scene.Geometry
import com.jme3.scene.shape.Box

/*
 * Main entry point for the BasicGame-on-Kotlin application.
 */
fun main() {
    val app = Main()
    app.start()
}

class Main : SimpleApplication() {
    override fun simpleInitApp() {
        val mesh = Box(1f, 1f, 1f)
        val geometry = Geometry("Box", mesh)

        val material = Material(assetManager, Materials.UNSHADED)
        material.setColor("Color", ColorRGBA.Blue)
        geometry.setMaterial(material)

        rootNode.attachChild(geometry)
    }
}
