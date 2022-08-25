import fs from "fs";
import path from "path";
import { defineConfig } from "vite";
import { resolve } from "path";
import reactRefresh from "@vitejs/plugin-react-refresh";

const inputPath = resolve("./src"),
  outputPath = resolve("./dist");

function getEntries() {
  const entry = {};
  const allfiles = fs.readdirSync(inputPath);
  allfiles.forEach((filename) => {
    const pname = path.join(`${inputPath}/${filename}`);
    const info = fs.statSync(pname);
    if (info.isDirectory()) {
      entry[filename] = `${pname}/index`;
    }
  });

  return entry;
}

export default defineConfig({
  jsx: "react",
  plugins: [reactRefresh],
  build: {
    rollupOptions: {
      input: getEntries(),
    },
    outDir: outputPath,
  },
  resolve: {
    extensions: [".js", ".ts", ".jsx", ".tsx", ".json"],
    alias: {
      "@": resolve(__dirname, "src"),
    },
  },
  server: {
    host: "0.0.0.0",
    port: 9112,
    open: false,
    proxy: {
      "/api": {
        target: "http://127.0.0.1:9012",
        changeOrigin: true,
      },
      "/uapi": {
        target: "http://127.0.0.1:3001",
        changeOrigin: true,
        rewrite: (path) => path.replace(/^\/uapi/, '')
      },
    },
  },
});
