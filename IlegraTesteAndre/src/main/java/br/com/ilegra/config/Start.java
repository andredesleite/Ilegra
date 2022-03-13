package br.com.ilegra.config;

import br.com.ilegra.constants.AppConstants;
import br.com.ilegra.controller.LendoArquivos;

import java.io.IOException;
import java.nio.file.*;
import java.util.Optional;

public class Start {

    public static void main(String[] args) throws IOException, InterruptedException {

        WatchService watcher = FileSystems.getDefault().newWatchService();
        //Diretório que será verificado se o arquivo foi criado
        Path diretorio = Paths.get(AppConstants.DIRETORIO_HOME + AppConstants.DIRETORIO_PADRAO_LEITURA);
        //registra o serviço criado
        diretorio.register(watcher, StandardWatchEventKinds.ENTRY_CREATE);

        while (true) {
            WatchKey key = watcher.take();
            Optional<WatchEvent<?>> watchEvent = key.pollEvents().stream().findFirst();
            if (watchEvent.isPresent()) {
                if (watchEvent.get().kind() == StandardWatchEventKinds.OVERFLOW) {
                    continue;
                }

                Path path = (Path) watchEvent.get().context();
                //Verifica se o arquivo possui a extensão txt
                if (path.toString().endsWith(".dat")) {
                    LendoArquivos lendoArquivos = new LendoArquivos();
                    lendoArquivos.obeterArquivosDoDiretorio();
                }
            }

            boolean valid = key.reset();
            if (!valid) {
                break;
            }


        }
        watcher.close();
    }
}
