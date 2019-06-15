
(ns app.config )

(def cdn?
  (cond
    (exists? js/window) false
    (exists? js/process) (= "true" js/process.env.cdn)
    :else false))

(def dev?
  (let [debug? (do ^boolean js/goog.DEBUG)]
    (cond
      (exists? js/window) debug?
      (exists? js/process) (not= "true" js/process.env.release)
      :else true)))

(def site
  {:dev-ui "http://localhost:8100/main-fonts.css",
   :release-ui "http://cdn.tiye.me/favored-fonts/main-fonts.css",
   :cdn-url "http://cdn.tiye.me/api-drafter/",
   :cdn-folder "fe.jimu.io:cdn/api-drafter",
   :title "API drafter",
   :icon "http://cdn.tiye.me/logo/respo.png",
   :storage-key "api-drafter",
   :upload-folder "tiye.me:repo/jimengio/api-drafter/"})
