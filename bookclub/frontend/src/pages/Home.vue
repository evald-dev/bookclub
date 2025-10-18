<script>

</script>

<template>

  <div class="relative min-h-screen w-full flex items-center justify-center p-8 ">
    
    <div class="container mx-auto">
      <div class="flex flex-col md:flex-row items-center justify-center gap-16 md:gap-8">

        <div class="flex flex-col text-center md:text-left">
          
          <h1 class="text-8xl font-bold animate-fade-down">
            Knigoeb
          </h1>
          
          <p class="text-3xl  font-light mt-2">
          read books together
          </p>

          <div class="w-full max-w-sm mt-8 space-y-3 mx-auto md:mx-0">
            <div class="h-2.5 bg-gradient-to-r from-accent to-primary rounded-full w-3/4"></div>
            <div class="h-2.5 bg-gradient-to-r from-accent via-primary to-transparent rounded-full w-full md:ml-8"></div>
            <div class="h-2.5 bg-gradient-to-r from-accent via-primary to-transparent rounded-full w-5/6 md:ml-4"></div>
          </div>

          <div class="mt-12">
            <button class="btn btn-xs sm:btn-sm md:btn-md lg:btn-lg xl:btn-xl">Start reading</button>


          </div>
        </div>

        <div class="w-full max-w-sm md:w-1/2 mt-12 md:mt-0">
          <div class="relative w-full" style="padding-bottom: 125%; perspective: 1000px;">
            
            <div classclass="absolute w-full h-full bg-gray-100 opacity-60 rounded-lg shadow-lg
                        transform -rotate-12 translate-x-4 top-8">
            </div>
            
            <div class="absolute w-full h-full bg-gray-100 opacity-80 rounded-lg shadow-lg
                        transform -rotate-6 translate-x-2 top-4">
            </div>

            <div class="absolute w-full h-full bg-white rounded-lg shadow-2xl p-6">
              
              <div class="flex flex-row gap-4">
                <div class="w-1/3 h-20 bg-gray-200 rounded-md"></div>
                <div class="flex-1 space-y-3 pt-2">
                  <div class="h-5 bg-gray-300 rounded-full w-full"></div>
                  <div class="h-5 bg-gray-300 rounded-full w-full"></div>
                  <div class="h-5 bg-gray-300 rounded-full w-3/4"></div>
                </div>
              </div>
              
            </div>
          </div>
        </div>
        
      </div>
    </div>
  </div>
</template>
