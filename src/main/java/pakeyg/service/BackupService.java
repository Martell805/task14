package pakeyg.service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;

@Service
@RequiredArgsConstructor
@Slf4j
public class BackupService {
    @Value("${app.bookBackupFile}")
    private String bookBackupPath;

    @Value("${app.authorBackupFile}")
    private String authorBackupPath;

    private final BookService bookService;
    private final AuthorService authorService;

    @Scheduled(cron = "0 0/30 * * * *")
    public void doScheduledTask() throws IOException {
        File bookFile = new File(bookBackupPath);
        FileUtils.deleteQuietly(bookFile);
        FileUtils.writeLines(bookFile, bookService.getAll());

        File authorFile = new File(authorBackupPath);
        FileUtils.deleteQuietly(authorFile);
        FileUtils.writeLines(authorFile, authorService.getAll());
    }
}
